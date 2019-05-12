import React, {Component} from 'react';
import axios from 'axios'

class ListJournalsComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            journals: ["Test"],
            message: null
        };

    }

    async componentDidMount() {
        this.refreshJournal();
    }

    refreshJournal() {
        let self = this;

        return axios.get('http://localhost:8080/journal/getJournals')
            .then(function (response) {
                console.log(response);
                console.log(response.status);

                self.setState({journals: response.data});
            })

            .catch(error => {
                console.log('Error fetching and parsing data', error);
            });
    }

    deleteJournalById(id) {
        let self = this;

        axios.delete(`http://localhost:8080/journal/deleteJournal/${id}`)
            .then(function(response) {
                console.log(response);

                self.refreshJournal();
            });
    }

    render(props) {
        return <div className="container">
            <h3>All Courses</h3>
            <div className="container">
                <table className="table">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Pain Level</th>
                        <th>Notes</th>
                        <th>Owner</th>
                        <th>Created At</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.journals.map(
                            journal =>
                            <tr key={journal.id}>
                                <td>{journal.id}</td>
                                <td>{journal.pain}</td>
                                <td>{journal.notes}</td>
                                <td>{journal.owner}</td>
                                <td>{journal.createdAt}</td>
                                <td><button className="btn btn-danger" onClick={() => this.deleteJournalById(journal.id)}>DeleteJournalTest</button></td>
                            </tr>
                        )
                    }
                    </tbody>
                </table>

            </div>
        </div>
    }
}

export default ListJournalsComponent
