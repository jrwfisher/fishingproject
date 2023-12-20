import axios from 'axios'

export default {
    fetchAllFish() {
        return axios.get('http://localhost:9000/fish');
    }
}