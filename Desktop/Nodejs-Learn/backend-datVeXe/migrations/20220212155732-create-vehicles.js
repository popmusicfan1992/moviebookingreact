"use strict";
module.exports = {
	async up(queryInterface, Sequelize) {
		await queryInterface.createTable("Vehicles", {
			id: {
				allowNull: false,
				autoIncrement: true,
				primaryKey: true,
				type: Sequelize.INTEGER,
			},
			name: {
				type: Sequelize.STRING,
			},
			description: {
				type: Sequelize.STRING,
			},
			type: {
				type: Sequelize.STRING,
			},
			numberFloors: {
				type: Sequelize.INTEGER,
			},
			passengerCarId: {
				type: Sequelize.INTEGER,
				onDelete: "CASCADE",
				references: {
					model: "passengercarcompanies",
					key: "id",
				},
			},
			createdAt: {
				allowNull: false,
				type: Sequelize.DATE,
			},
			updatedAt: {
				allowNull: false,
				type: Sequelize.DATE,
			},
		});
	},
	async down(queryInterface, Sequelize) {
		await queryInterface.dropTable("Vehicles");
	},
};
