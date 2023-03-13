"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.int31Write = exports.shl32 = exports.and32 = exports.mul32 = exports.add32 = exports.xor32 = exports.hashPassword = exports.xor_default = exports.or = exports.xor = exports.sha1 = void 0;
const crypto_1 = __importDefault(require("crypto"));
// export const sha1 = (msg:string) => crypto.createHash('sha1').update(msg, 'binary').digest('binary');
exports.sha1 = (msg) => crypto_1.default.createHash('sha1').update(msg, 'binary').digest('binary');
exports.xor = (buff1, buff2) => {
    var b1 = Buffer.from(buff1, 'binary');
    var b2 = Buffer.from(buff2, 'binary');
    var len = b1.length;
    var result = Buffer.alloc(len);
    for (let i = 0; i < len; i++)
        result[i] = b1[i] ^ b2[i];
    return result;
};
exports.or = (buff1, buff2) => {
    var b1 = Buffer.from(buff1, 'binary');
    var b2 = Buffer.from(buff2, 'binary');
    var len = b1.length;
    var result = Buffer.alloc(len);
    for (let i = 0; i < len; i++)
        result[i] = b1[i] | b2[i];
    return result;
};
exports.xor_default = (a, b) => {
    a = Buffer.from(a, 'binary');
    b = Buffer.from(b, 'binary');
    var result = Buffer.allocUnsafe(a.length);
    for (var i = 0; i < a.length; i++) {
        result[i] = (a[i] ^ b[i]);
    }
    return result;
};
exports.hashPassword = function (password) {
    var nr = [0x5030, 0x5735];
    var add = 7;
    var nr2 = [0x1234, 0x5671];
    var result = Buffer.alloc(8);
    if (typeof password === 'string') {
        password = Buffer.from(password);
    }
    for (var i = 0; i < password.length; i++) {
        var c = password[i];
        if (c === 32 || c === 9) {
            // skip space in password
            continue;
        }
        nr = exports.xor32(nr, exports.add32(exports.mul32(exports.add32(exports.and32(nr, [0, 63]), [0, add]), [0, c]), exports.shl32(nr, 8)));
        nr2 = exports.add32(nr2, exports.xor32(exports.shl32(nr2, 8), nr));
        add += c;
    }
    exports.int31Write(result, nr, 0);
    exports.int31Write(result, nr2, 4);
    return result;
};
exports.xor32 = function (a, b) {
    return [a[0] ^ b[0], a[1] ^ b[1]];
};
exports.add32 = function (a, b) {
    var w1 = a[1] + b[1];
    var w2 = a[0] + b[0] + ((w1 & 0xFFFF0000) >> 16);
    return [w2 & 0xFFFF, w1 & 0xFFFF];
};
exports.mul32 = function (a, b) {
    // based on this example of multiplying 32b ints using 16b
    // http://www.dsprelated.com/showmessage/89790/1.php
    var w1 = a[1] * b[1];
    var w2 = (((a[1] * b[1]) >> 16) & 0xFFFF) + ((a[0] * b[1]) & 0xFFFF) + (a[1] * b[0] & 0xFFFF);
    return [w2 & 0xFFFF, w1 & 0xFFFF];
};
exports.and32 = function (a, b) {
    return [a[0] & b[0], a[1] & b[1]];
};
exports.shl32 = function (a, b) {
    // assume b is 16 or less
    var w1 = a[1] << b;
    var w2 = (a[0] << b) | ((w1 & 0xFFFF0000) >> 16);
    return [w2 & 0xFFFF, w1 & 0xFFFF];
};
exports.int31Write = function (buffer, number, offset) {
    buffer[offset] = (number[0] >> 8) & 0x7F;
    buffer[offset + 1] = (number[0]) & 0xFF;
    buffer[offset + 2] = (number[1] >> 8) & 0xFF;
    buffer[offset + 3] = (number[1]) & 0xFF;
};
