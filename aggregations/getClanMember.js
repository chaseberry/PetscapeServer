db.getCollection("clanMembers").aggregate(
    [
        {
            $match: {
                _id: ObjectId()
            }
        },

    ]
);