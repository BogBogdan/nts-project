import React, { useEffect, useState } from 'react';
import RecordDetails from './RecordDetails';

const UserData = () => {
    const [userData, setUserData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [currentIndex, setCurrentIndex] = useState(0); // Drži indeks trenutnog zapisa

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8082/api/teltonika/parse');
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const data = await response.json();
                console.log(data);
                setUserData(data);
            } catch (error) {
                setError(error);
            } finally {
                setLoading(false);
            }
        };

        fetchData();
    }, []);

    const handleNext = () => {
        if (currentIndex < userData.length - 1) {
            setCurrentIndex(currentIndex + 1);
        }
    };

    const handlePrev = () => {
        if (currentIndex > 0) {
            setCurrentIndex(currentIndex - 1);
        }
    };

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error.message}</div>;
    }

    return (
        <div>
            <h2>User Data</h2>
            {userData && userData.length > 0 ? (
                <div>
                    <button onClick={handlePrev} disabled={currentIndex === 0}>
                        &lt; Prev
                    </button>
                    <button onClick={handleNext} disabled={currentIndex === userData.length - 1}>
                        Next &gt;
                    </button>
                    <RecordDetails record={userData[currentIndex].records} />
                </div>
            ) : (
                <p>No user data available.</p>
            )}
        </div>
    );
};

export default UserData;
