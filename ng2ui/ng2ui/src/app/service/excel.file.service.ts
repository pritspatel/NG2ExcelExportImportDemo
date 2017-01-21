
import {Injectable} from "@angular/core";
import {Headers, Http} from "@angular/http";
import {Observable} from "rxjs";

@Injectable()
export class ExcelFileService{

    constructor(private _http : Http){}

    downloadFile(){
        let url = "http://localhost:9999/api/download";
        var headers = new Headers();
        headers.append('responseType', 'arraybuffer');
        return this._http.get( url)
            .map(res => new Blob([res],{ type: 'application/vnd.ms-excel' }))
            .catch((error : any ) => Observable.throw(error));
    }
}