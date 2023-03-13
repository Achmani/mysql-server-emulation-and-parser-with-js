"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const packet_1 = __importDefault(require("./packet"));
class IOk extends packet_1.default {
    constructor(version) {
        super(version);
        this.AffectedRows = 1;
        this.LastInsertID = 1;
        this.StatusFlags = 1;
        this.Warnings = 1;
    }
    _log() {
        console.log("🚀 ~ file: ok.ts ~ line 23 ~ Ok ~ Warnings", this.Warnings);
        console.log("🚀 ~ file: ok.ts ~ line 23 ~ Ok ~ StatusFlags", this.StatusFlags);
        console.log("🚀 ~ file: ok.ts ~ line 23 ~ Ok ~ LastInsertID", this.LastInsertID);
        console.log("🚀 ~ file: ok.ts ~ line 23 ~ Ok ~ AffectedRows", this.AffectedRows);
    }
}
exports.default = IOk;
