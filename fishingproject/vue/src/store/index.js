import { createStore } from 'vuex'


export default createStore({
  state: {
    fish: [
      {
        "name": "",
        "description": "",
        "regions": [],
      }
    ]
  },
  getters: {
  },
  mutations: {
    GET_ALL_FISH(state, fish) {
      state.fish = fish;
    }
  },
  actions: {
  },
  modules: {
  }
})
