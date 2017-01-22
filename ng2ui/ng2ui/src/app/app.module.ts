import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {ExcelFileService} from "./service/excel.file.service";
import {CarService} from "./service/car.service";
import {DataTable} from "primeng/primeng";
import {DataTableModule} from "primeng/components/datatable/datatable";
import {FileUploadModule} from "primeng/components/fileupload/fileupload";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    DataTableModule,
      FileUploadModule
  ],
  providers: [ExcelFileService,CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
