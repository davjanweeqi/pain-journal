import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { JournalComponent } from 'journal.component';
import { JournalService } from './journal.service';

@NgModule({
  declarations: [
    AppComponent,
    JournalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
    FormsModule,
    HttpModule
  ],
  providers: [JournalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
