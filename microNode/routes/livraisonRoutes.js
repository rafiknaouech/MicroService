const express = require('express');
const router = express.Router();
const livraisonController = require('../controllers/livraisonController');

// Routes pour les livraisons
router.get('/', livraisonController.getAllLivraisons);
router.get('/:id', livraisonController.getLivraisonById);
router.post('/', livraisonController.createLivraison);
router.put('/:id', livraisonController.updateLivraison);
router.delete('/:id', livraisonController.deleteLivraison);

module.exports = router;
