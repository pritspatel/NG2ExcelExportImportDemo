
import {Injectable} from "@angular/core";
import {Headers, Http, RequestMethod, ResponseContentType} from "@angular/http";
import {Observable} from "rxjs";
//import {fileSaver} = require("file-saver");

@Injectable()
export class ExcelFileService{
    private url = "http://localhost:9999/api/download";
    private importUrl = "http://localhost:9999/api/upload";
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

    importFile(file : File){
        this._http.post(this.importUrl, file,{
            method: RequestMethod.Post,
                headers: new Headers()
        }).subscribe(
            (response) => {
                var res = response.json();
                console.log('Response from import : ' + res);

            }
        );
    }
}