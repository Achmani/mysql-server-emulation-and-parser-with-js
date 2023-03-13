import ErrorVer8 from "../8.0/constant/error";
import ClientVer8 from "../8.0/constant/client";

export default class Constants {

    Client: ClientVer8;
    Error: ErrorVer8;

    constructor(version: number) {

        this.Client = new ClientVer8();
        this.Error = new ErrorVer8();

        //default for the future can use if from version
        if (version == 8) {
            this.Client = new ClientVer8();
            this.Error = new ErrorVer8();
        }
    }

}