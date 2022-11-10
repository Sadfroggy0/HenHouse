var houseData = Vue.resource("/houses{/id}")
var chickenData = Vue.resource("/chickens/house{/id}")
var chickenDataSorted = Vue.resource("/chickens/house{/id}")
var sortById = function (d1, d2) { return (d1.id > d2.id) ? 1 : -1; };

var form = new Vue({
    el:'#form',
    template:''
})

var house = new Vue({
    template:'<house-list :houses="sortedList"></house-list>',
    el:'#house',
    data: {
        houses:[],
    },
    created: function(){
        houseData.get().then(result =>
            result.json().then(data =>
                data.forEach(house => this.houses.push(house))
            ))
        houseData.get().then(result =>
            result.json().then(data =>
                data.forEach(house => console.log(house))
            ))
    },
    computed:{
        sortedList(){
            return this.houses.sort(sortById)
        }
    }
})

Vue.component('house-list',{
    props:['houses'],
    data:function (){
        return {
            house_: null
        }
    },
    template: '<div>' +
              '<house-form :houses = "houses" :houseFromEdit = "house_"></house-form>'+
            '    <table class="table table-success table-striped">\n' +
            '        <thead>\n' +
            '        <tr>\n' +
            '            <th scope="col">#</th>\n' +
            '            <th scope="col">Name</th>\n' +
            '        </tr>\n' +
            '        </thead>\n' +
            '        <tbody>\n' +
            '        <tableForm v-for="house in houses" :house="house" :houses = "houses" :key="house.id"' +
        '             :editMethod="editMethod">\n'+
            '        </tableForm>\n' +
            '        </tbody>\n' +
            '    </table>\n'+
            '</div>',
    methods:{
        editMethod:function(house){
            this.house_ = house;
        }
    }

})
Vue.component('house-form',{
    props:['houses','houseFromEdit'],
    data:function (){
        return{
            id:'',
            name: ''
        }
    },
    watch:{
        houseFromEdit:function (newVal, oldVal) {
            this.name = newVal.name;
            this.id = newVal.id;
        }

    },
    template:'<div>' +
        '<input type="text" placeholder="write new house name" v-model="name"/>'+
        '<input type="button" value="save" v-on:click="save" />'+
        '</div>',
    methods:{
        save:function (){
            var house ={id:this.id, name: this.name};
            if(this.id){
                houseData.update({id:this.id},house).then(
                    result => result.json().then(data => {
                        var index = getIndex(this.houses, data.id)
                        this.houses.splice(index, 1, data);
                        this.name = '';
                        this.id = '';
                    }))
            }
            else {
                houseData.save({}, house).then(result => result.json().then(data => {
                    this.houses.push(data);
                    this.name = '';
                }))
            }
        }
    },

})

Vue.component('tableForm',{
    data:function(){
        return{
            tempList:[]
        }
    },
    props:['house','houses','editMethod'],
    template:'<tr>' +
       ' <th scope="row">{{house.id}}</th>'+
'            <td>{{house.name}}</td>\n' +
'            <td><input type="button" value="Edit" @click="edit"></td>\n' +
'            <td><input type="button" value="Delete" @click="del"></td>\n' +
// '            <td><input type="button" value="MoreInfo" @click="inf"></td>\n' +
// // '            <td><a :href=" \'/chickens/house/\' + house.id ">More</a></td>\n' +
        '</tr>',

    methods:{
        edit:function (){
            this.editMethod(this.house)
        },
        del:function (){
            houseData.remove({id: this.house.id}).then(result =>{
                if (result.ok){
                    this.houses.splice(this.houses.indexOf(this.house),1)
                }
            })
        },

    }

})



