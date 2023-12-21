import axios from 'axios'

export default {
    fetchAllFish() {
        return axios.get('http://localhost:9000/fish');
    },
    fetchFishByRegion(region) {
        return axios.get('http://localhost:9000/fish/' + region);
    },
    fetchRegions() {
        return axios.get('http://localhost:9000/regions');
    }
}