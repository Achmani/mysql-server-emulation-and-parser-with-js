import crypto from 'crypto';

// export const sha1 = (msg:string) => crypto.createHash('sha1').update(msg, 'binary').digest('binary');
export const sha1 = (msg: any) => crypto.createHash('sha1').update(msg, 'binary').digest('binary');

export const xor = (buff1, buff2) => {
    var b1 = Buffer.from(buff1, 'binary');
    var b2 = Buffer.from(buff2, 'binary');
    var len = b1.length;
    var result = Buffer.alloc(len);
    for (let i = 0; i < len; i++) result[i] = b1[i] ^ b2[i];
    return result;
};

export const or = (buff1: string, buff2: string) => {
    var b1 = Buffer.from(buff1, 'binary');
    var b2 = Buffer.from(buff2, 'binary');
    var len = b1.length;
    var result = Buffer.alloc(len);
    for (let i = 0; i < len; i++) result[i] = b1[i] | b2[i];
    return result;
};

export const xor_default = (a, b) => {
    a = Buffer.from(a, 'binary');
    b = Buffer.from(b, 'binary');
    var result = Buffer.allocUnsafe(a.length);
    for (var i = 0; i < a.length; i++) {
        result[i] = (a[i] ^ b[i]);
    }
    return result;
}

export const hashPassword = function (password) {
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

        nr = xor32(nr, add32(mul32(add32(and32(nr, [0, 63]), [0, add]), [0, c]), shl32(nr, 8)));

        nr2 = add32(nr2, xor32(shl32(nr2, 8), nr));

        add += c;

    }

    int31Write(result, nr, 0);
    int31Write(result, nr2, 4);

    return result;
};

export const xor32 = function (a, b) {
    return [a[0] ^ b[0], a[1] ^ b[1]];
};

export const add32 = function (a, b) {
    var w1 = a[1] + b[1];
    var w2 = a[0] + b[0] + ((w1 & 0xFFFF0000) >> 16);

    return [w2 & 0xFFFF, w1 & 0xFFFF];
};

export const mul32 = function (a, b) {
    // based on this example of multiplying 32b ints using 16b
    // http://www.dsprelated.com/showmessage/89790/1.php
    var w1 = a[1] * b[1];
    var w2 = (((a[1] * b[1]) >> 16) & 0xFFFF) + ((a[0] * b[1]) & 0xFFFF) + (a[1] * b[0] & 0xFFFF);

    return [w2 & 0xFFFF, w1 & 0xFFFF];
};

export const and32 = function (a, b) {
    return [a[0] & b[0], a[1] & b[1]];
};

export const shl32 = function (a, b) {
    // assume b is 16 or less
    var w1 = a[1] << b;
    var w2 = (a[0] << b) | ((w1 & 0xFFFF0000) >> 16);

    return [w2 & 0xFFFF, w1 & 0xFFFF];
};

export const int31Write = function (buffer, number, offset) {
    buffer[offset] = (number[0] >> 8) & 0x7F;
    buffer[offset + 1] = (number[0]) & 0xFF;
    buffer[offset + 2] = (number[1] >> 8) & 0xFF;
    buffer[offset + 3] = (number[1]) & 0xFF;
};