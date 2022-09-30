import Sequelize from "sequelize";

const sequelize = new Sequelize("taurus-bd", "admin-taurus", "#Gfgrupo4", {
  host: "svr-taurus.database.windows.net",
  dialect: "mssql",
  quoteIdentifiers: false,
  define: {
    syncOnAssociation: true,
    timestamps: false,
    underscored: true,
    underscoredAll: true,
    freezeTabName: true,
  },
});

sequelize
  .authenticate()
  .then(() => {
    console.log("Connection has been stablished!");
  })
  .catch((err) => {
    console.error("Unable to connect to the database.");
    console.error(err.message);
  });

export default sequelize;