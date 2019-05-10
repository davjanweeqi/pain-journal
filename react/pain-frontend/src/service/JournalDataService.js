import axios from 'axios'

const ID_API_URL = 'http://localhost:8080/journal/getJournal';

class JournalDataService {
    //retreiveCourse(id) {
    retreiveCourse() {
        return axios.get(ID_API_URL);
    }
}

export default new JournalDataService()
