"use strict";
const {Model} = require("sequelize");
module.exports = (sequelize, DataTypes) => {
	class User extends Model {
		/**
		 * Helper method for defining associations.
		 * This method is not a part of Sequelize lifecycle.
		 * The `models/index` file will call this method automatically.
		 */
		static associate({Ticket, Comment, Rate}) {
			this.hasMany(Ticket, {foreignKey: "user_id", as: "user", onDelete: "cascade"});
			this.hasMany(Comment, {foreignKey: "userId", as: "userComment", onDelete: "cascade"});
			this.hasMany(Rate, {foreignKey: "userId", as: "userRate", onDelete: "cascade"});
		}
	}
	User.init(
		{
			name: DataTypes.STRING,
			email: DataTypes.STRING,
			password: DataTypes.STRING,
			numberPhone: DataTypes.STRING,
			avatar: DataTypes.STRING,
			type: DataTypes.STRING,
		},
		{
			sequelize,
			modelName: "User",
		}
	);
	return User;
};
