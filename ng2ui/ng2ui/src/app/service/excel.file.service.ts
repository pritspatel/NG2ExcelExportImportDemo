
import {Injectable} from "@angular/core";
import {Headers, Http, RequestMethod, ResponseContentType} from "@angular/http";
import {Observable} from "rxjs";
//import {fileSaver} = require("file-saver");

@Injectable()
export class ExcelFileService{
    private url = "http://localhost:9999/api/download";
    constructor(private _http : Http){}

    exportFile() {
        this._http.get(this.url, {
            method: RequestMethod.Get,
            responseType: ResponseContentType.Blob,
            headers: new Headers()
        }).subscribe(
            (response) => {
                var blob = new Blob([response.blob()], {type: 'application/zip'});
                var filename = 'file.xls';
                saveAs(blob, filename);
            }
        );
    }
}