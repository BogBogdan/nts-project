import React from 'react';
import RecordDetails from './RecordDetails';

const DataViewer = ({ data }) => {

  if (!data || !Array.isArray(data.records) || data.records.length === 0) {
    return <div>No records available</div>;
  }

  return (
    <div>
      {data.records.map((record, index) => (
        <RecordDetails key={index} record={record} />
      ))}
    </div>
  );
};

export default DataViewer;
