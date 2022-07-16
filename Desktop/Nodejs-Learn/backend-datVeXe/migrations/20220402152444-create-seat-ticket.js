"use strict";
module.exports = {
	async up(queryInterface, Sequelize) {
		await queryInterface.createTable("SeatTickets", {
			id: {
				allowNull: false,
				autoIncrement: true,
				primaryKey: true,
				type: Sequelize.INTEGER,
			},
			ticketId: {
				type: Sequelize.INTEGER,
				onDelete: "CASCADE",
				references: {
					model: "tickets",
					key: "id",
				},
			},
			seatId: {
				type: Sequelize.INTEGER,
				onDelete: "CASCADE",
				references: {
					model: "seats",
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
		await queryInterface.dropTable("SeatTickets");
	},
};
