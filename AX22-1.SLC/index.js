import * as th from './three/build/three.module.js'

let scene, camera, renderer

let ground=()=>{

    let grouGeo = new th.PlaneGeometry(1000,1000)
    let loader = new th.TextureLoader()
    let texture = loader.load('./assets/grass.jpg')
    let grouMat = new th.MeshStandardMaterial({
        map: texture
    })

    let grouMesh = new th.Mesh(grouGeo, grouMat)
    grouMesh.position.set(0,0,0)
    grouMesh.rotation.set(-Math.PI/2,0,0)

    grouMesh.receiveShadow = true
    scene.add(grouMesh)
}

let cylinder=()=>{

    let cylinGeo = new th.CylinderGeometry(5,5,10,3)
    let cylinMat = new th.MeshPhongMaterial({
        color: 0xa15c2a
    })

    let cylinMesh = new th.Mesh(cylinGeo, cylinMat)
    cylinMesh.position.set(0,0,0)
    cylinMesh.rotation.set(Math.PI/6,0,Math.PI/2)

    cylinMesh.castShadow = true
    cylinMesh.receiveShadow = true

    scene.add(cylinMesh)
}

let box=()=>{

    let boxGeo = new th.BoxGeometry(10,1,50)
    let boxMat = new th.MeshPhongMaterial({
        color: 0xcc9c7c
    })

    let boxMesh = new th.Mesh(boxGeo, boxMat)
    boxMesh.position.set(0,5.5,0)
    boxMesh.rotation.set(Math.PI/16,0,0)
    boxMesh.castShadow = true
    boxMesh.receiveShadow = true

    scene.add(boxMesh)
}

let sphere=()=>{
    
    let sphGeo = new th.SphereGeometry(5,32,16)
    let loader = new th.TextureLoader()
    let texture = loader.load('./assets/soccer-ball.jpg')
    let sphMat = new th.MeshPhongMaterial({
        map: texture
    })

    let sphMesh = new th.Mesh(sphGeo, sphMat)
    sphMesh.position.set(0,6.5,23)
    sphMesh.rotation.set(0,Math.PI,0)

    sphMesh.castShadow = true
    sphMesh.receiveShadow = true

    scene.add(sphMesh)
}

let tire=()=>{

    let tireGeo = new th.TorusGeometry(6,2,16,100)
    let tireMat = new th.MeshStandardMaterial({
        color: 0x3e444c
    })

    let tireMesh = new th.Mesh(tireGeo, tireMat)
    tireMesh.position.set(0,2,-20)
    tireMesh.rotation.set(-Math.PI/2,0,Math.PI/3)

    tireMesh.castShadow = true
    tireMesh.receiveShadow = true
    scene.add(tireMesh)
}

let spot=()=>{

    let spotlight = new th.SpotLight(0xffcd80, 0.3)
    spotlight.position.set(0,50,0)

    spotlight.castShadow = true
    scene.add(spotlight)
}

let direct=()=>{

    let directlight = new th.DirectionalLight(0xffffff, 1.0)
    directlight.position.set(-100,30,200)

    // directlight.castShadow = true
    scene.add(directlight)
}

let init=()=>{
    scene = new th.Scene()

    renderer = new th.WebGLRenderer({
        antialias : true
    })
    renderer.setSize(window.innerWidth, window.innerHeight)
    renderer.shadowMap.enabled = true

    let fov = 50
    let aspect = window.innerWidth / window.innerHeight
    let near = 1
    let far = 50000

    camera = new th.PerspectiveCamera(fov, aspect, near , far)
    camera.position.set(-50,35,20)
    camera.lookAt(0,0,0)

    document.body.appendChild(renderer.domElement)
    ground()
    cylinder()
    box()
    sphere()
    tire()
    spot()
    direct()
}

let render=()=>{
    requestAnimationFrame(render)
    renderer.render(scene, camera)
}

window.onload=()=>{
    init()
    render()
}