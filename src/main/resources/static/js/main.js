
var serverData = Vue.resource("/chickens{/id}")
var eggData = Vue.resource("/egg{/chicken_id}")

function getIndex(list, id){
 for (var i = 0; i<list.length; i++){
     if(list[i].id === id) {
         return i;
     }
     return -1;
 }
}

Vue.component('chicken-row',{
    props:['chicken','editMethod','chickens'],

    template:
        '  <div class="accordion-item">\n' +
        '    <h2 class="accordion-header" id="panelsStayOpen-headingOne">\n' +
        '      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">\n' +
        '        (ID: {{chicken.id}}) {{chicken.name}}\n' +
        '      </button>\n' +
        '    </h2>\n' +
        '    <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingOne">\n' +
        '      <div class="accordion-body">\n' +
                ' <strong> Name of the chicken:</strong> {{chicken.name}} <br/> <strong>houseID</strong>:{{chicken.house_id}} | {(chicken.eggList}}' +
                    '<br/>'+
                    '<span>'+
                        '<input type="button" value="Edit" v-on:click="edit" >'+
                        '<input type="button" value="Add Egg" v-on:click="addEgg" >'+
                        '<input type="button" value="Delete" v-on:click="del" >'+
                    '</span>'+
        '      </div>\n' +
        '    </div>\n' +
        '  </div>',




    // template:'<div>' +
    //         '<i>({{chicken.id}})</i> {{chicken.name}} | houseID:{{chicken.house_id}}' +
    //             '<span>' +
    //                 '<input type="button" value="Edit" v-on:click="edit" >'+
    //                 '<input type="button" value="Add Egg" v-on:click="addEgg" >'+
    //                 '<input type="button" value="Delete" v-on:click="del" >'+
    //             '</span>'+
    //     '</div>',
    methods:{
        addEgg:function (){
            var newEgg ={ chicken_id: this.chicken.id}
            eggData.save({}, newEgg).then(result => result.json().then(data=>console.log(data)))

        },
        edit:function (){
            this.editMethod(this.chicken)
        },
        del:function (){
            serverData.remove({id: this.chicken.id}).then(result =>{
                if (result.ok){
                    this.chickens.splice(this.chickens.indexOf(this.chicken),1)
                }
            })
        }
    }

});

Vue.component('chicken-list', {
    props: ['chickens'],
    data:function (){
      return{
          chicken: null
      }
    },

    template:
        '<div>' +
            '<chicken-form :chickens="chickens" :chickenFromEdit="chicken"/>'+
                '<div class="accordion" id="accordionOpenExample" style="padding-top: 40.5px">\n' +
                    '<chicken-row v-for="chicken in chickens" :chicken="chicken" :key="chicken.id"' +
                    ':editMethod="editMethod" :chickens="chickens"/> '+
                '</div>'+
            // '<chicken-row v-for="chicken in chickens" :chicken="chicken" :key="chicken.id"' +
            // ':editMethod="editMethod" :chickens="chickens"/> '+
        '</div>',
    methods:{
        editMethod:function(chicken){
            this.chicken = chicken;
        }
    }

});

Vue.component('chicken-form',{
    props: ['chickens','chickenFromEdit'],
    data:function () {
        return{
            text: '',
            house_id: '',
            id: ''
        }
    },
    watch:{
        chickenFromEdit:function(newVal,oldVal){
            this.text = newVal.name;
            this.house_id = newVal.house_id;
            this.id = newVal.id;
        }
    },
    template:'<div>' +
            '<input type="text" placeholder="write new chicken name" v-model="text"/>'+
            '<input type="text" placeholder="write house id" v-model="house_id"/>'+
            '<input type="button" value="save" v-on:click="save" />'+
        '</div>',
    methods:{
        save:function (){
            var chicken ={id:this.id, name: this.text, house_id: this.house_id};
            if(this.id){
                serverData.update({id:this.id},chicken).then(
                    result => result.json().then(data =>{
                        var index = getIndex(this.chickens,data.id )
                        this.chickens.splice(index,1,data);
                        this.text = '';
                        this.house_id = '';
                        this.id = '';
                    }))
            }
            else {
                serverData.save({}, chicken).then(result => result.json().then(data => {
                    this.chickens.push(data);
                    this.text = '';
                    this.house_id = '';
                }))
            }
        }
    }
});


var mp = new Vue({
    el: '#mp',
    template: '<chicken-list :chickens= "chickens"/>',
    data: {
        chickens:[],
    },
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

});
