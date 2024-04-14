<template>
    <div>
        <h2 class="office-name">{{ office.officeName }}</h2>
        <h3 class="email">{{ office.email }}</h3>
    </div>
</template>


<script>
export default {
    props: {
        office: Object
    }
}
</script>


<style></style>