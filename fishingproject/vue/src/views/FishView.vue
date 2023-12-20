<template>
 <div>
    <h1>Fish</h1>
    <ul>
        <li v-for="fish in $store.state.fish" :key="fish.id" class="list-item">
            {{fish.name}}
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
        }
    },
    methods: {

    },
    created() {
        FishService.fetchAllFish().then(response => {
            this.$store.commit('GET_ALL_FISH', response.data);
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