import React, { useState } from 'react';
import './App.css';

/**
 * Componente principal de la interfaz frontend para el Sistema de Monitoreo de Salud Animal.
 * Permite gestionar el registro básico y listar los animales bajo estándares limpios de React.
 * 
 * @author Cristóbal Acevedo
 * @version 1.0
 */
function App() {
  // Estado para almacenar la lista de animales y los datos del formulario
  const [animales, setAnimales] = useState([]);
  const [nombre, setNombre] = useState('');
  const [especie, setEspecie] = useState('');
  const [estadoSalud, setEstadoSalud] = useState('');

  /**
   * Maneja el evento de envío del formulario para registrar un nuevo animal.
   * Valida que los campos no estén vacíos antes de agregarlo al estado.
   */
  const handleSubmit = (e) => {
    e.preventDefault();
    
    if (!nombre || !especie || !estadoSalud) {
      alert('Por favor complete todos los campos obligatorios.');
      return;
    }

    const nuevoAnimal = {
      id: Date.now(),
      nombre,
      especie,
      estadoSalud
    };

    // Actualiza la lista de animales
    setAnimales([...animales, nuevoAnimal]);

    // Limpia el formulario
    setNombre('');
    setEspecie('');
    setEstadoSalud('');
  };

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '20px', maxWidth: '600px', margin: '0 auto' }}>
      <h2>Sistema de Monitoreo de Salud Animal - Módulo Frontend</h2>
      
      {/* Formulario de Registro */}
      <form onSubmit={handleSubmit} style={{ background: '#f4f4f4', padding: '15px', borderRadius: '5px', marginBottom: '20px' }}>
        <h3>Registrar Nuevo Animal</h3>
        <div style={{ marginBottom: '10px' }}>
          <label>Nombre:</label><br />
          <input 
            type="text" 
            value={nombre} 
            onChange={(e) => setNombre(e.target.value)} 
            style={{ width: '100%', padding: '8px' }}
          />
        </div>
        <div style={{ marginBottom: '10px' }}>
          <label>Especie:</label><br />
          <input 
            type="text" 
            value={especie} 
            onChange={(e) => setEspecie(e.target.value)} 
            style={{ width: '100%', padding: '8px' }}
          />
        </div>
        <div style={{ marginBottom: '10px' }}>
          <label>Estado de Salud:</label><br />
          <input 
            type="text" 
            value={estadoSalud} 
            onChange={(e) => setEstadoSalud(e.target.value)} 
            style={{ width: '100%', padding: '8px' }}
          />
        </div>
        <button type="submit" style={{ background: '#007bff', color: 'white', padding: '10px 15px', border: 'none', cursor: 'pointer' }}>
          Registrar Animal
        </button>
      </form>

      {/* Lista de Registros */}
      <div>
        <h3>Lista de Animales Monitoreados</h3>
        {animales.length === 0 ? (
          <p>No hay registros actuales en el sistema.</p>
        ) : (
          <ul style={{ listStyle: 'none', padding: 0 }}>
            {animales.map((item) => (
              <li key={item.id} style={{ background: '#e9ecef', margin: '10px 0', padding: '10px', borderRadius: '4px' }}>
                <strong>{item.nombre}</strong> ({item.especie}) - <em>Estado: {item.estadoSalud}</em>
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
}

export default App;