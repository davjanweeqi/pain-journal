import { Component, OnInit } from '@angular/core';
import { Journal } from './journal';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'journal',
  templateUrl: './journal.component.html'
})

export class JournalComponent implements OnInit {
  journals: Journal[];
  newJournal: Journal = new Journal();
  editing: boolean = false;
  editingJournal: Journal = new Journal();

   ngOnInit(): void {
      this.getJournals();
    }

    getJournal: void {
      this.journalService.getJournals().then(journals => this.journals = journals);
    }

   createJournal(todoForm: NgForm): void {
      this.journalService.createJournal(this.newJournal).then(createHournal => {
        journalForm.reset();
        this.newJournal = new Journal();
        this.journals.unshift(createJournal);
      });
   }

   deleteJournal(id: string): void {
      this.journalService.deleteJournal().then(() => this.journals = this.journals.filter(journal => journal.id != id));
   }

   updateJournal(todoData: Journal): void {

   }

   toggleCompleted(todoData: Journal): void {

   }

   editTodo(todoData: Journal): void {

   }

   clearEditing(): void {

   }
}
