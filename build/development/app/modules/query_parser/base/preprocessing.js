"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const SqlBaseLexer_1 = require("../../antlr4/SqlBaseLexer");
class Preprocessing {
    constructor() {
    }
    onlyUnique(value, index, self) {
        return self.indexOf(value) === index;
    }
    removeQuoted(query) {
        let removeQuoted = new RegExp("([`'\"]+)", 'gmi');
        return query.replace(removeQuoted, "");
    }
    addQuote(query, listNotReserved) {
        listNotReserved.forEach(element => {
            let isnumexp = new RegExp("(?<=LIMIT *)" + element + "|(?<=WHERE.*= *)" + element, 'gmi');
            let isnum = isnumexp.test(query);
            if (isnum) {
            }
            else {
                let addquoteexp = new RegExp("\\b" + element + "\\b", 'gmi');
                let isopr = new RegExp("(?<=\\= *)" + element, 'gmi');
                let opr = isopr.test(query) ? "`" : "`";
                query = query.replace(addquoteexp, opr + element + opr);
            }
        });
        return query;
    }
    uppercaseReserved(query, listReserved) {
        listReserved.forEach(el => {
            let reg = new RegExp(el, 'gmi');
            query = query.replace(reg, el.toUpperCase());
        });
        return query;
    }
    removeDatabase(query) {
        let reg = new RegExp('`chrono`\\.', 'gmi');
        query = query.replace(reg, "");
        return query;
    }
    process(query) {
        query = this.removeDatabase(query);
        let splitexp = new RegExp("([A-Za-z0-9_-``''\"]+)", 'gmi');
        let splitquery = query.match(splitexp);
        let literalNames = SqlBaseLexer_1.SqlBaseLexer.VOCABULARY["literalNames"];
        let listNotReserved = [];
        let listReserved = [];
        if (splitquery) {
            splitquery.forEach(value => {
                let tmpcheck = "'" + value.toUpperCase() + "'";
                if (!literalNames.includes(tmpcheck)) {
                    listNotReserved.push(value);
                }
                else {
                    listReserved.push(value);
                }
            });
        }
        else {
        }
        listNotReserved = listNotReserved.filter(this.onlyUnique);
        listReserved = listReserved.filter(this.onlyUnique);
        let resultquery = this.addQuote(query, listNotReserved);
        resultquery = this.uppercaseReserved(resultquery, listReserved);
        return resultquery;
    }
}
exports.default = Preprocessing;
