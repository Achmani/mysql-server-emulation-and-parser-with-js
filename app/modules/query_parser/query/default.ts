import Query from "./query";
export default class Default extends Query {
    async process(): Promise<string> {
        return this.query;
    }
}