### query heart data 


    db.getCollection('waterEntity').aggregate(
    	[
		    {$project: {date: 1, type: 1, amount: 1, inamount: {$cond: {if: {$eq: ['$type', 'in']}, then: '$amount', else: 0}}, outamount: {$cond: {if: {$eq: ['$type', 'out']}, then: '$amount', else: 0}}, _id: 1}},
		    {$group: {_id: {_id: '$_id', groupdate: {$substr: ['$date', 0, 10]}, date: '$date', type: '$type', amount: '$amount', }, groupinamount: {$sum: '$inamount'}, groupoutamount: {$sum: '$outamount'}}},
		    {$project: {groupdate: '$_id.groupdate', date: '$_id.date', groupinamount: 1, groupoutamount: 1, info: {_id: '$_id._id', date: '$_id.date', type: '$_id.type', amount: '$_id.amount', }, _id: 0}},
		    {$group: {_id: {date: '$groupdate'}, groupdate: {$max: '$date'}, groupinamount: {$sum: '$groupinamount'}, groupoutamount: {$sum: '$groupoutamount'}, listdata: {$push: '$info'}}},
		    {$sort: {_id: -1}}
    	]
    )


### query heart data 


    db.getCollection('heartEntity').aggregate(
	    [
		    {$match: {date: { $gte: ISODate("2016-10-25T09:05:14.688Z") }}},
		    {$group: {_id: {_id: '$_id', groupdate: {$substr: ['$date', 0, 10]}, date: '$date', low: '$low', high: '$high', heartbeat: '$heartbeat', weight: '$weight' }}},
		    {$project: {groupdate: '$_id.groupdate', date: '$_id.date', info: {_id: '$_id._id', nowdate : Date(178929000), date: '$_id.date', low: '$_id.low', high: '$_id.high', heartbeat: '$_id.heartbeat', weight: '$_id.weight' }, _id: 0}},
		    {$group: {_id: {date: '$groupdate'}, groupdate: {$max: '$date'}, listdata: {$push: '$info'}}},
		    {$sort: {_id: -1}}
	    ]
    )