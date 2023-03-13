import { SqlBaseLexer } from "../../antlr4/SqlBaseLexer";

export default class Preprocessing {

    constructor() {
    }

    private onlyUnique(value: string, index: number, self: Array<string>) {
        return self.indexOf(value) === index;
    }

    private removeQuoted(query: string) {
        let removeQuoted = new RegExp("([`'\"]+)", 'gmi');
        return query.replace(removeQuoted, "");
    }

    private addQuote(query: string, listNotReserved: Array<string>) {
        listNotReserved.forEach(element => {
            let isnumexp = new RegExp("(?<=LIMIT *)" + element + "|(?<=WHERE.*= *)" + element, 'gmi');
            let isnum = isnumexp.test(query)
            if (isnum) {

            } else {
                let addquoteexp = new RegExp("\\b" + element + "\\b", 'gmi');
                let isopr = new RegExp("(?<=\\= *)" + element, 'gmi');
                let opr = isopr.test(query) ? "`" : "`";
                query = query.replace(addquoteexp, opr + element + opr)
            }
        });
        return query;
    }

    private uppercaseReserved(query: string, listReserved: Array<string>) {
        listReserved.forEach(el => {
            let reg: RegExp = new RegExp(el, 'gmi');
            query = query.replace(reg, el.toUpperCase());
        });
        return query;
    }

    private removeDatabase(query: string) {
        let reg: RegExp = new RegExp('`chrono`\\.', 'gmi');
        query = query.replace(reg, "");
        return query;
    }

    public process(query: string) {
        query = this.removeDatabase(query);
        let splitexp = new RegExp("([A-Za-z0-9_-``''\"]+)", 'gmi');
        let splitquery = query.match(splitexp);
        let literalNames = SqlBaseLexer.VOCABULARY["literalNames"];
        let listNotReserved: (string)[] = [];
        let listReserved: (string)[] = [];
        if (splitquery) {
            splitquery.forEach(value => {
                let tmpcheck = "'" + value.toUpperCase() + "'";
                if (!literalNames.includes(tmpcheck)) {
                    listNotReserved.push(value);
                } else {
                    listReserved.push(value);
                }
            });
        } else {

        }
        listNotReserved = listNotReserved.filter(this.onlyUnique);
        listReserved = listReserved.filter(this.onlyUnique);
        let resultquery = this.addQuote(query, listNotReserved);
        resultquery = this.uppercaseReserved(resultquery, listReserved);
        return resultquery;
    }

}