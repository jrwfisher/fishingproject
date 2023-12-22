<template>
 <div>
    <h1>Fish</h1>
    <select>
        <option v-for="region in $store.state.regions" :key="region.id" value="option1">{{ region.name }}</option>
    </select>
    
    <button @click="showAllFish">Display All Fish</button>
    <ul v-if="showFish">
        <li v-for="fish in $store.state.fish" :key="fish.id" class="list-item">
            {{fish.name}} {{ fish.id }}
        </li>
    </ul>
 </div>
</template>
<script>
import FishService from '@/services/FishService';
export default {
    
  name: 'FishView',
  components: {

  },
    data() {
        return {
            showFish: false,
            selectedRegion: "",
        }
    },
    methods: {
        showAllFish() {
            this.showFish = !this.showFish
        }

    },
    created() {
        FishService.fetchAllFish().then(response => {
            this.$store.commit('SET_ALL_FISH', response.data);
        })
        FishService.fetchRegions().then(response => {
            this.$store.commit('SET_REGIONS', response.data);
        })
    }

}
</script>
<style>
li {
  margin-left: 0;
  padding-left: 0;
  list-style: none;
}

</style>