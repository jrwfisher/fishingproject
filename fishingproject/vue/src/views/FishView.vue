<template>
    <div>
        <h1>Fish Directory By Region</h1>
        <p>This is a work in progress, early development will focus on fish of Florida</p>
        <form>
            <select v-model="selectedRegion">
                <option v-for="region in $store.state.regions" :key="region.id">{{ region.name }}</option>
            </select>

            <button @click="showAllFish">Display All Fish</button>
        </form>
        <ul v-if="showFish">
            <li v-for="fish in $store.state.fish" :key="fish.id" class="list-item">
                {{ fish.name }} {{ fish.id }}
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
            if (this.selectedRegion != "") {
                FishService.fetchFishByRegion(this.selectedRegion).then(response => {
                    this.$store.commit('SET_ALL_FISH', response.data);
                })
                this.showFish = true;
            }
        }

    },
    created() {
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