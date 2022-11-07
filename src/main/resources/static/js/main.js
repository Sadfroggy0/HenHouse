
var serverData = Vue.resource("/chickens{/id}")

Vue.component('chicken-list', {
    props: ['chickens'],
    template: '<ol><li v-for="chicken in chickens ">{{ chicken.id }} {{chicken.name}}</li></ol>',

});

Vue.component('chicken-form',{
    props: ['chickens'],
    data:function () {
        return{
            id: '',
            text: '',
            house_id: ''
        }
    },
    template:'<div>' +
            '<input type="text" placeholder="write new chicken id" v-model="id"/>'+
            '<input type="text" placeholder="write new chicken name" v-model="text"/>'+
            '<input type="text" placeholder="write house id" v-model="house_id"/>'+
            '<input type="button" value="save" v-on:click="save" />'+
        '</div>',
    methods:{
        save:function (){
            var chicken ={id: this.id ,name: this.text, house_id: this.house_id};
            serverData.save({},chicken).then(result => result.json().then(data=>{
                this.chickens.push(data)
            }))
        }
    }
});

var mp = new Vue({
    el: '#mp',
    template:
        '<div>' +
            '<chicken-form :chickens="chickens"></chicken-form>' +
            '<chicken-list :chickens= "chickens" />'+
        '</div>',

    created: function (){
        serverData.get().then(result =>
        result.json().then(data =>
            data.forEach(chicken => this.chickens.push(chicken))
        ))
        serverData.get().then(result =>
            result.json().then(data =>
                data.forEach(chicken => console.log(chicken))
            ))
    },

    data: {
        chickens: []
    }
});
