import {state} from "./store";
import Vuex from 'vuex'
import Vue from 'vue'

Vue.use(Vuex)

export default new Vuex.Store({
  state: state,
  mutations: {
    changePlaying(state,music){
      state.playingInfo = music
    },
    changeSearchSongs(state,list) {
      state.searchSongs = list
    },
    changeLikeList(state,list) {
      state.likeList = list
    },
    changePlayList(state,list) {
      state.playList = list
    },
    changeTypeList(state,list){
      state.typeList = list
    },
    changePlayStatus(state,status){
      state.playing = status
    },
    changeDialogVisible(state,visible){
      state.dialogVisible = visible
    },
    changePlayIndex(state,value){
      state.playingIndex = value
    }
  },
  actions: {
  },
  modules: {
  },
  getters:{

  },

})
