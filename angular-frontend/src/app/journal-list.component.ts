import { Component, OnInit } from '@angular/core';
import { Journal } from './journal';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'journal-list',
  templateUrl: './journal.component.html'
})

export class JournalComponent implements OnInit {
  journals: Journal[];
  newJournal: Journal = new Journal();
  editing: false;
  editingJournal: Journal = new Journal();

   ngOnInit(): void {
      this.getJournal();
    }

    constructor(private journalService: JournalService,)

    getJournal: void {
      this.journalService.getJournal().then(journals => this.journals = journals);
    }

   createJournal(journalForm: NgForm): void {
      this.journalService.createJournal(this.newJournal).then(createHournal => {
        journalForm.reset();
        this.newJournal = new Journal();
        this.journals.unshift(createJournal);
      });
   }

   deleteJournal(id: string): void {
      this.journalService.deleteJournal().then(() => this.journals = this.journals.filter(journal => journal.id != id));
   }

   updateJournal(journalData: Journal): void {
      console.log(journalData);
      this.journalService.updateJournal(journalData).then(updateJournal => let existingJournal = this.journals.find(journal => journal.id === updatedJournal.id));
      Object.assign(existingJournal, updatedJournal);
      this.clearEditing();
   }

   toggleCompleted(journalData: Journal): void {
      journalData.completed = !journalData.completed;
      this.journalService.updateJournal(journalData).then(updateJournal => let existingJournal = this.journals.find(journal => journal.id === updatedJournal.id));
      Object.assign(existingJournal, updatedJournal);
      this.clearEditing();
   }

   editTodo(journalData: Journal): void {
      this.editing = true;
      Object.assign(this.editingJournal, journalData);
   }

   clearEditing(): void {
      this.editingJournal = new Journal();
      this.editing = false;
   }
}
