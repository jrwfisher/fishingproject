import { createStore } from 'vuex'


export default createStore({
  state: {
    fish: [
      {
        "name": "",
        "description": "",
      }
    ],
    "regions": [
      {"name": ""}
    ],
  },
  getters: {
  },
  mutations: {
    SET_ALL_FISH(state, fish) {
      state.fish = fish;
    },
    SET_REGIONS(state, regions) {
      state.regions = regions;
    }
  },
  actions: {
  },
  modules: {
  }
})
