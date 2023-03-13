"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const buffer_1 = require("buffer");
class UBuffer {
    constructor() {
        this.buf = buffer_1.Buffer.alloc(0);
        this.pos = 0;
        this.seek = 0;
        this.cap = 0;
    }
    /* Init Buffer */
    reset() {
        this.alloc(0);
    }
    alloc(n) {
        this.buf = buffer_1.Buffer.alloc(n);
        this.pos = 0;
        this.seek = 0;
        this.cap = 0;
    }
    from(v) {
        this.buf = buffer_1.Buffer.from(v);
        this.pos = this.buf.length;
        this.seek = 0;
        this.cap = 0;
    }
    /* Buffer Utility */
    readU8() {
        const v = this.buf[this.seek];
        this.seek += 1;
        return v;
    }
    writeU8(v) {
        this.buf[this.pos] = v;
        this.pos++;
    }
    readU16() {
        var byte1 = 0xff & this.buf[this.seek];
        var byte2 = 0xff & (this.buf[this.seek + 1] << 8);
        this.seek += 2;
        return byte1 | byte2;
    }
    writeU16(v) {
        var byte1 = 0xff & v;
        var byte2 = 0xff & (v >> 8);
        this.buf[this.pos] = byte1;
        this.buf[this.pos + 1] = byte2;
        this.pos += 2;
    }
    readU24() {
        var byte1 = 0xff & this.buf[this.seek];
        var byte2 = 0xff & (this.buf[this.seek + 1] << 8);
        var byte3 = 0xff & (this.buf[this.seek + 2] << 16);
        this.seek += 3;
        return byte1 | byte2 | byte3;
    }
    writeU24(v) {
        var byte1 = 0xff & v;
        var byte2 = 0xff & (v >> 8);
        var byte3 = 0xff & (v >> 16);
        this.buf[this.pos] = byte1;
        this.buf[this.pos + 1] = byte2;
        this.buf[this.pos + 2] = byte3;
        this.pos += 3;
    }
    readU32() {
        var byte1 = 0xff & this.buf[this.seek];
        var byte2 = 0xff & (this.buf[this.seek + 1] << 8);
        var byte3 = 0xff & (this.buf[this.seek + 2] << 16);
        var byte4 = 0xff & (this.buf[this.seek + 3] << 24);
        this.seek += 4;
        return byte1 | byte2 | byte3 | byte4;
    }
    writeU32(v) {
        var byte1 = 0xff & v;
        var byte2 = 0xff & (v >> 8);
        var byte3 = 0xff & (v >> 16);
        var byte4 = 0xff & (v >> 24);
        this.buf[this.pos] = byte1;
        this.buf[this.pos + 1] = byte2;
        this.buf[this.pos + 2] = byte3;
        this.buf[this.pos + 3] = byte4;
        this.pos += 4;
    }
    readU64() {
        var byte1 = 0xff & this.buf[this.seek];
        var byte2 = 0xff & (this.buf[this.seek + 1] << 8);
        var byte3 = 0xff & (this.buf[this.seek + 2] << 16);
        var byte4 = 0xff & (this.buf[this.seek + 3] << 24);
        var byte5 = 0xff & (this.buf[this.seek + 4] << 32);
        var byte6 = 0xff & (this.buf[this.seek + 5] << 40);
        var byte7 = 0xff & (this.buf[this.seek + 6] << 48);
        var byte8 = 0xff & (this.buf[this.seek + 7] << 56);
        this.seek += 8;
        return byte1 | byte2 | byte3 | byte4 | byte5 | byte6 | byte7 | byte8;
    }
    writeU64(v) {
        var byte1 = 0xff & v;
        var byte2 = 0xff & (v >> 8);
        var byte3 = 0xff & (v >> 16);
        var byte4 = 0xff & (v >> 24);
        var byte5 = 0xff & (v >> 32);
        var byte6 = 0xff & (v >> 40);
        var byte7 = 0xff & (v >> 48);
        var byte8 = 0xff & (v >> 56);
        this.buf[this.pos] = byte1;
        this.buf[this.pos + 1] = byte2;
        this.buf[this.pos + 2] = byte3;
        this.buf[this.pos + 3] = byte4;
        this.buf[this.pos + 4] = byte5;
        this.buf[this.pos + 5] = byte6;
        this.buf[this.pos + 6] = byte7;
        this.buf[this.pos + 7] = byte8;
        this.pos += 8;
    }
    readZero(n) {
        this.seek += n;
    }
    writeZero(v) {
        for (let index = 0; index < v; index++) {
            this.buf[this.pos] = 0;
            this.pos++;
        }
    }
    readBytesWithToken(b) {
        var i = this.seek + 1;
        while (this.buf[i] != b) {
            i++;
        }
        var v = this.buf.slice(this.seek, i);
        this.seek = i;
        return v;
    }
    readBytes(n) {
        let tmp = this.seek;
        this.seek += n;
        return this.buf.slice(tmp, this.seek);
    }
    writeBytes(v) {
        v.forEach(el => {
            this.buf[this.pos] = el;
            this.pos++;
        });
    }
    readString(n) {
        const v = this.buf[this.seek, n];
        this.seek += n;
        return v;
    }
    readStringNul() {
        return this.readBytesWithToken(0x00);
    }
    writeString(v) {
        this.buf.write(v, this.pos);
        this.pos += v.length;
    }
    writeLenEncode(v) {
        if (v < 251) {
            this.writeU8(v);
        }
        else if (v >= 251 && v < (1 << 16)) {
            this.writeU8(0xfc);
            // this.writeU16(uint16(v));
            this.writeU16(v);
        }
        else if (v >= (1 << 16) && v < (1 << 24)) {
            this.writeU8(0xfd);
            // this.writeU24(uint32(v));
            this.writeU24(v);
        }
        else {
            this.writeU8(0xfe);
            this.writeU64(v);
        }
    }
    // writeLengthCodedNumber(value, defaultalloc) {
    //     let binary = this.bits(value, 32).join("");
    //     let results :(number)[] = [];
    //     results.push(this.bin2dec(this.reverseString(binary.slice(0, 8))));
    //     results.push(this.bin2dec(this.reverseString(binary.slice(8, 16))));
    //     results.push(this.bin2dec(this.reverseString(binary.slice(16, 24))));
    //     results.push(this.bin2dec(this.reverseString(binary.slice(24, 32))));
    //     for (let index = 0; index < defaultalloc; index++) {
    //         this.writeU8(0x00 + results[index]);
    //     }
    // }
    data() {
        return this.buf.slice(0, this.pos);
    }
}
exports.default = UBuffer;
