import { Component } from '@angular/core';
import {ExcelFileService} from "./service/excel.file.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';

  constructor(private fileService : ExcelFileService){}

  downloadExcel(){
    console.log("Downloading excel from server....")
    this.fileService.exportFile();
  }
}
