import React, {Component} from 'react';
import axios from 'axios'
import DayPickerInput from 'react-day-picker/DayPickerInput'
import 'react-day-picker/lib/style.css'

class CreateJournalComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            id: '',
            pain: '',
            owner: '',
            notes: '',
            date: undefined
        };
    }

    createJournal(id, pain, owner, notes, date) {

        console.log(id + ' ' + pain + '' + date + '');

        axios.put('http://localhost:8080/journal/createJournal/' + id + '/'  + pain + '/' + owner + '/' + notes + '/' + date)
            .then(function (response) {
                console.log(response);
                console.log(response.status);
            })
    }

    onChange = (e) => {
        /*
          Because we named the inputs to match their
          corresponding values in state, it's
          super easy to update the state
        */
        this.setState({ [e.target.name]: e.target.value });
    };

    handleDayChange(day) {
        this.setState({ day: day.toLocaleDateString()})
    }

    render() {

        const { id, pain, owner, notes, day} = this.state;

        return <div className="container">

            <h3>Create New Journal</h3>
            <div className="container">
                <DayPickerInput onDayChange={(newDate) => this.handleDayChange(newDate)}/>
                <form className="ui form" onSubmit={() => this.createJournal(id, pain, owner, notes, day)}>
                    <label>ID: </label>
                    <input type="text" name="id" value={id} onChange={this.onChange}/>
                    <label>Pain Level 1-10:</label>
                    <input type="text" name="pain" value={pain} onChange={this.onChange}/>
                    <label>Name:</label>
                    <input type="text" name="owner" value={owner} onChange={this.onChange}/>
                    <label>Notes</label>
                    <input type="text" name="notes" value={notes} onChange={this.onChange}/>
                    <input type="submit" value="Submit" className="ui positive button" />
                </form>
            </div>
        </div>
    }
}

export default CreateJournalComponent
