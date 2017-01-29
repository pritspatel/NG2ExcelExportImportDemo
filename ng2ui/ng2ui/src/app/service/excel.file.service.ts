
import {Injectable} from "@angular/core";
import {Headers, Http, RequestMethod, ResponseContentType} from "@angular/http";
import {Observable} from "rxjs";
import * as FileSaver from 'file-saver';

@Injectable()
export class ExcelFileService{
    private url = "http://localhost:9999/api/download";
    private importUrl = "http://localhost:9999/api/upload";
    constructor(private _http : Http){}

    /*exportFile() {
        this._http.get(this.url, {
            method: RequestMethod.Get,
            responseType: ResponseContentType.Blob,
            headers: new Headers()
        }).subscribe(
            (response) => {
                var blob = new Blob([response.blob()], {type: 'application/vnd.ms-excel'});
                var filename = 'file.xls';
                FileSaver.saveAs(blob, filename);
            }
        );
    }*/
    exportFile(){
        this._http.get(this.url,{responseType : ResponseContentType.Blob})
            .map( (response) => {
                let blob = response.blob();
                console.log('Received excel data....');
                return{
                    data : new Blob([blob],{type : 'application/vnd.ms-excel'}),
                    filename : 'test.xls'
                }
            })
            .subscribe(
                (res)=>{
                    console.log('Exporting excel file');
                    FileSaver.saveAs(res.data,res.filename);
                }
            )
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