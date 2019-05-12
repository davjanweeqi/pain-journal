import React, {Component} from 'react';
import ListJournalsComponent from './ListJournalsComponent';
import CreateJournalComponent from './CreateJournalComponent'

class JournalApp extends Component {
    constructor(props) {
        super(props);

        this.handleCreateClick = this.handleCreateClick.bind(this);
        this.handleViewAllJournal = this.handleViewAllJournal.bind(this);

        this.state = {creatingJournal: false};
    }

    handleCreateClick() {
        this.setState({creatingJournal: true});
    }

    handleViewAllJournal() {
        this.setState({creatingJournal: false});
    }

    render() {

        const creatingJournal = this.state.creatingJournal;
        let view;
        let button;

        if(creatingJournal) {
            view = <CreateJournalComponent/>;
            button = <button className={"ui primary button"} onClick={() => this.handleViewAllJournal()}>View All Journals</button>
        } else {
            view = <ListJournalsComponent />;
            button = <button className={"ui primary button"} onClick={() => this.handleCreateClick()}>Create New Journal</button>
        }

        return (
            <>
                <h1 className={"ui header"}>Journal Application</h1>
                <div>
                    {view}
                </div>
                <div>
                    {button}
                </div>
            </>
        )
    }
}

export default JournalApp;
