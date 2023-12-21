const mongoose = require('mongoose');

const livraisonSchema = new mongoose.Schema({
  idLivreur: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Employe', // Référence à l'entité Employe pour lier à l'ID du livreur
    required: true,
  },
  statutLivraison: {
    type: String,
    enum: ['En attente', 'En cours', 'Livré'],
    default: 'En attente',
    required: true,
  },
  idCommande: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Commande', // Référence à l'entité Commande pour lier à l'ID de la commande
    required: true,
  },
  idLivraison: {
    type: String,
    required: true,
    unique: true,
  },

});

const livraison = mongoose.model('Livraison', livraisonSchema);

module.exports = livraison;
