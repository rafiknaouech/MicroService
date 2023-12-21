const Livraison = require('../models/livraison');

module.exports = {
  // Récupérer toutes les livraisons
  async getAllLivraisons(req, res) {
    try {
      const livraisons = await Livraison.find();
      res.json(livraisons);
    } catch (err) {
      res.status(500).json({ message: err.message });
    }
  },

  // Récupérer une livraison par son ID
  async getLivraisonById(req, res) {
    try {
      const livraison = await Livraison.findById(req.params.id);
      if (livraison === null) {
        return res.status(404).json({ message: 'Livraison non trouvée' });
      }
      res.json(livraison);
    } catch (err) {
      res.status(500).json({ message: err.message });
    }
  },

  // Créer une livraison
  async createLivraison(req, res) {
    const livraison = new Livraison(req.body);
    try {
      const newLivraison = await livraison.save();
      res.status(201).json(newLivraison);
    } catch (err) {
      res.status(400).json({ message: err.message });
    }
  },

  // Mettre à jour une livraison
  async updateLivraison(req, res) {
    try {
      const livraison = await Livraison.findByIdAndUpdate(req.params.id, req.body, { new: true });
      if (livraison === null) {
        return res.status(404).json({ message: 'Livraison non trouvée' });
      }
      res.json(livraison);
    } catch (err) {
      res.status(400).json({ message: err.message });
    }
  },

  // Supprimer une livraison
  async deleteLivraison(req, res) {
    try {
      const livraison = await Livraison.findByIdAndDelete(req.params.id);
      if (livraison === null) {
        return res.status(404).json({ message: 'Livraison non trouvée' });
      }
      res.json({ message: 'Livraison supprimée avec succès' });
    } catch (err) {
      res.status(500).json({ message: err.message });
    }
  }
};
