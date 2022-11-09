var houseData = Vue.resource("/houses{/id}")
var chickenData = Vue.resource("/chickens/house{/id}")

var house = new Vue({
    //template:'<house-list :houses="houses"></house-list>',
    el:'#house',
    data: {
        houses:[],
    },
    created: function (){
        houseData.get().then(result =>
            result.json().then(data =>
                data.forEach(house => this.houses.push(house))
            ))
        houseData.get().then(result =>
            result.json().then(data =>
                data.forEach(house => console.log(house))
            ))
    },
})

Vue.component('house-list',{
    props:['houses'],
    template: '<div><table-form v-for="house in houses" :house = "house"></table-form></div>'
})


Vue.component('tableForm',{
    props:['house'],
    template:'<input type="button" value="More" v-on:click="more">',
    methods:{
        more:function (){

        }
    }

})



