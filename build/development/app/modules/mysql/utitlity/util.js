"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.writeIntToBuffer = exports.isJson = exports.binToInt = exports.intToBin = exports.convertBase = exports.convertDecimal = exports.writeLengthCodedNumberBackup = exports.writeLengthCodedNumber = exports.bin2dec = exports.reverseString = exports.bits = void 0;
exports.bits = (n, b = 32) => [...Array(b)].map((x, i) => (n >> i) & 1);
exports.reverseString = function reverseString(str) {
    return [...str].reverse().join("");
};
exports.bin2dec = function bin2dec(binStr) {
    const lastIndex = binStr.length - 1;
    let total = 0;
    for (let i = 0; i < binStr.length; i++) {
        if (binStr[lastIndex - i] === '1') {
            total += (Math.pow(2, i));
        }
    }
    return total;
};
exports.writeLengthCodedNumber = function writeLengthCodedNumber(value, defaultalloc) {
    let _buffer = Buffer.alloc(defaultalloc);
    let binary = exports.bits(value, 32).join("");
    let results;
    results = [];
    results.push(exports.bin2dec(exports.reverseString(binary.slice(0, 8))));
    results.push(exports.bin2dec(exports.reverseString(binary.slice(8, 16))));
    results.push(exports.bin2dec(exports.reverseString(binary.slice(16, 24))));
    results.push(exports.bin2dec(exports.reverseString(binary.slice(24, 32))));
    for (let index = 0; index < defaultalloc; index++) {
        _buffer[index] = 0x00 + results[index];
    }
    return _buffer;
};
exports.writeLengthCodedNumberBackup = function writeLengthCodedNumberBackup(value, defaultalloc) {
    let _buffer = Buffer.alloc(defaultalloc);
    let _offset = 0;
    let BIT_16 = Math.pow(2, 16);
    let BIT_24 = Math.pow(2, 24);
    // The maximum precision JS Numbers can hold precisely
    // Don't panic: Good enough to represent byte values up to 8192 TB
    let IEEE_754_BINARY_64_PRECISION = Math.pow(2, 53);
    if (value === null) {
        _buffer[_offset++] = 251;
        return _buffer;
    }
    if (value <= 250) {
        _buffer[_offset++] = value;
        return _buffer;
    }
    if (value > IEEE_754_BINARY_64_PRECISION) {
        throw new Error('writeLengthCodedNumber: JS precision range exceeded, your ' +
            'number is > 53 bit: "' + value + '"');
    }
    if (value < BIT_16) {
        // _buffer = Buffer.alloc(3);
        _buffer[_offset++] = 252;
    }
    else if (value < BIT_24) {
        // _buffer = Buffer.alloc(4);
        _buffer[_offset++] = 253;
    }
    else {
        // _buffer = Buffer.alloc(9);
        _buffer[_offset++] = 254;
    }
    // 16 Bit
    _buffer[_offset++] = value & 0xff;
    _buffer[_offset++] = (value >> 8) & 0xff;
    if (value < BIT_16) {
        return _buffer;
    }
    // 24 Bit
    _buffer[_offset++] = (value >> 16) & 0xff;
    if (value < BIT_24) {
        return _buffer;
    }
    _buffer[_offset++] = (value >> 24) & 0xff;
    // Hack: Get the most significant 32 bit (JS bitwise operators are 32 bit)
    let value_temp = value.toString(2);
    value_temp = value_temp.substr(0, value_temp.length - 32);
    value = parseInt(value_temp, 2);
    _buffer[_offset++] = value & 0xff;
    _buffer[_offset++] = (value >> 8) & 0xff;
    _buffer[_offset++] = (value >> 16) & 0xff;
    // Set last byte to 0, as we can only support 53 bits in JS (see above)
    _buffer[_offset++] = 0;
    return _buffer;
};
exports.convertDecimal = function convertDecimal(number) {
    let base = number / 255;
    return exports.convertBase(number, base);
};
exports.convertBase = function convertBase(n, base) {
    let def_base = 8;
    let res = exports.intToBin(n);
    res = res.padStart(def_base * base, '0');
    let tmp_slice;
    tmp_slice = [];
    let j = base - 1;
    for (let i = 0; i < base; i++) {
        tmp_slice[j--] = res.slice(i * def_base, (i + 1) * def_base);
    }
    let tmp_data;
    tmp_data = [];
    for (let i = 0; i < base; i++) {
        tmp_data[i] = 0x00 + exports.binToInt(tmp_slice[i]).toString();
    }
    return tmp_data;
};
exports.intToBin = function intToBin(number, res = "") {
    if (number < 1) {
        if (res === "") {
            return "0";
        }
        else {
            return res;
        }
    }
    else {
        return intToBin(Math.floor(number / 2), number % 2 + res);
    }
};
exports.binToInt = function binToInt(number) {
    let results;
    results = parseInt(number, 2);
    return results;
    // results = Array.prototype.reduce(number, (p: number, c: number) => p * 2 + +c);
};
exports.isJson = function isJson(str) {
    try {
        JSON.parse(str);
    }
    catch (e) {
        return false;
    }
    return isNaN(str);
};
exports.writeIntToBuffer = function writeIntToBuffer(val) {
    let results = Buffer.from([val]);
    if (val > 256) {
        let a = Math.floor(val / 256);
        let b = val % 256;
        let tmp;
        tmp = [];
        for (let index = 0; index < a; index++) {
            tmp.push(0xfc);
        }
        tmp.push(0x00 + b);
        tmp.push(0x01);
        results = Buffer.from(tmp);
    }
    return results;
};
