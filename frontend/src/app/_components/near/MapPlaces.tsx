import { TMapPlace } from '@/types/response';
import React, {
  MutableRefObject,
  RefObject,
  useEffect,
  useRef,
  useState,
} from 'react';
import { Marker, useNavermaps } from 'react-naver-maps';
import { basicMarker } from '../naver-map/markers/basicMarker';

export default function MapPlaces({
  allPlaces,
  totalPages,
}: {
  allPlaces: TMapPlace[];
  totalPages: number;
}) {
  const markerRefs = useRef<Array<RefObject<naver.maps.Marker>>>(
    allPlaces.map(() => React.createRef()),
  );
  const navermaps = useNavermaps();
  const onClickBasicMarker = (id: number) => {
    console.log('clicked', id);
  };

  useEffect(() => {
    markerRefs.current = markerRefs.current.slice(0, allPlaces.length);
    console.log(markerRefs.current);
  }, [markerRefs.current]);
  return (
    <>
      {!!allPlaces.length &&
        allPlaces.map((place, idx) => {
          return (
            <Marker
              key={place.id}
              title={place.place_name}
              position={{ x: place.x, y: place.y }}
              icon={basicMarker(place.place_name)}
              onClick={() => onClickBasicMarker(place.id)}
              ref={markerRefs.current[idx]}
            ></Marker>
          );
        })}
    </>
  );
}
