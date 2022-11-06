
var serverData = Vue.resource("/chickens{/id}")

Vue.component('chicken-list', {
    props: ['chickens'],
    template: '<ol><li v-for="chicken in chickens ">{{ chicken.id }} {{chicken.name}}</li></ol>',

});

var mp = new Vue({
    el: '#mp',
    template: '<chicken-list :chickens= "chickens" />',
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
