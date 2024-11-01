import React from 'react';

// Mapa za prevođenje ID-a iz ioElements u opisne nazive (prema Teltonika dokumentaciji).
const ioElementDescriptions = {
  "1": "Ignition",
  "2": "Digital Input 1",
  "3": "Digital Input 2",
  "21": "Movement",
  "66": "Battery Voltage",
  "78": "Fuel Level",
  "81": "Temperature Sensor",
  "82": "Fuel Usage",
  "85": "Odometer",
  "87": "CAN Fuel Level",
  "89": "Accelerometer",
  "107": "Battery Level",
  "115": "Device Temperature",
  "179": "Vehicle Speed",
  "180": "Acceleration",
  "241": "Vehicle VIN",
  "69" : "GNSS Status",
  "72" : "Dallas Temperature 1",
  "83" : "Fuel Consumed",
  "84" : "Fuel Level",
  "182": "GNSS HDOP",
  "199": "Trip Odometer",
  "240": "LLS 2 Temperature"
};

const RecordDetails = ({ record }) => {

  console.log(record);
  if (!record) return <div>No record data available</div>;

  const { timestamp, longitude, latitude, ioElements } = record[0];

  const formatDate = (timestamp) => {
    return new Date(timestamp).toLocaleString();
  };

  return (
    <div>
      <h2>Record Details</h2>
      <p><strong>Timestamp:</strong> {formatDate(timestamp)}</p>
      <p><strong>Location:</strong> {latitude}, {longitude}</p>
      
      <h3>IO Elements</h3>
      <ul>
        {ioElements &&
          Object.entries(ioElements).map(([id, value]) => (
            <li key={id}>
              <strong>{ioElementDescriptions[id] || `ID ${id}`}:</strong> {value}
            </li>
          ))}
      </ul>
    </div>
  );
};

export default RecordDetails;
