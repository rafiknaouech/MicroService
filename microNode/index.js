const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const livraisonRoutes = require('./routes/livraisonRoutes');
const eurekaHelper = require('./eureka');
const cors = require('cors');
const app = express();
const PORT = process.env.PORT || 4000;

const mongoURL = process.env.MONGODB_URL;
// Connexion à MongoDB
console.log("mongoURL:", mongoURL); // Vérifier que mongoURL est défini correctement
mongoose.connect(mongoURL);


 
/* // Connexion à MongoDB
mongoose.connect('mongodb://127.0.0.1:27017/produit'); */
const db = mongoose.connection; 
// Vérifier la connexion à la base de données MongoDB
db.on('error', console.error.bind(console, 'Erreur de connexion à la base de données :'));
db.once('open', () => {
  console.log('Connexion à la base de données établie avec succès.');
});

app.use(bodyParser.json());
app.use(cors());
// Définir les routes pour les produits
app.use('/livraison', livraisonRoutes);

app.listen(PORT, () => {
  console.log(`Serveur démarré sur le port ${PORT}`);
});
eurekaHelper.registerWithEureka( PORT);
