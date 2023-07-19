const objArray = [
    {
        prop1: "String",
        prop2: 100,
        type: 'CAR'
    },
    {
        prop1: 'String',
        prop2: 200,
        type: 'BUS'
    }
]

const result = objArray.find(obj => obj.type === "BUS")
console.log(result)

