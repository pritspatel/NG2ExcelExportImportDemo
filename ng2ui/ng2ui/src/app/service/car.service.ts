
import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Car} from "../model/car.model";

@Injectable()
export class CarService{
    constructor(private _http  :Http){}

    getCars() : Observable<Car[]>{
        return this._http.get("http://localhost:9999/api/cars")
            .map((res : Response) => res.json())
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }
}