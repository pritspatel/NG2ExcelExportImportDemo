import {Component} from '@angular/core';
import {ExcelFileService} from "./service/excel.file.service";
import {Car} from "./model/car.model";
import {CarService} from "./service/car.service";


@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    private title = 'app works!';
    private cars: Car[];
    private uploadedFiles: any[] = [];

    constructor(private fileService: ExcelFileService, private carService: CarService) {
        this.carService.getCars().subscribe(
            cars => {
                console.log('Loading cars from backend....')
                this.cars = cars;
            },
            err => {
                // Log errors if any
                console.log(err);
            }
        );
    }

    downloadExcel() {
        console.log("Downloading excel from server....")
        this.fileService.exportFile();
    }

    importExcel() {
        console.log('Importing excel....')
    }

    onUpload(event) {
        for (let file of event.files) {
            this.uploadedFiles.push(file);
        }
    }
}
